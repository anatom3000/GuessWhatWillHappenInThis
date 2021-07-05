package fr.anatom3000.gwwhit.command;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import fr.anatom3000.gwwhit.Python;

import java.util.concurrent.CompletableFuture;

public class ScriptArgumentType implements ArgumentType<Python.Script> {
    @Override
    public Python.Script parse(StringReader reader) throws CommandSyntaxException {
        return new Python.Script(readString(reader));
    }
    
    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        for (Python.Script key : Python.getKeys()) {
            if (key.id().contains(" ")) key = new Python.Script('"' + key.id() + '"');
            builder.suggest(key.id().replace('\\', '/'));
        }
        return builder.buildFuture();
    }
    
    public static Python.Script getScript(final CommandContext<?> context, final String name) {
        return new Python.Script(context.getArgument(name, Python.Script.class).id().replace('/', '\\'));
    }
    
    
    // Hacks around StringReader
    public String readString(StringReader reader) throws CommandSyntaxException {
        if (!reader.canRead()) {
            return "";
        }
        final char next = reader.peek();
        if (StringReader.isQuotedStringStart(next)) {
            reader.skip();
            return reader.readStringUntil(next);
        }
        return readUnquotedString(reader);
    }
    
    public String readUnquotedString(StringReader reader) {
        final int start = reader.getCursor();
        while (reader.canRead() && isAllowedInUnquotedString(reader.peek())) {
            reader.skip();
        }
        return reader.getString().substring(start, reader.getCursor());
    }
    
    private boolean isAllowedInUnquotedString(char c) {
        return c >= '0' && c <= '9'
                || c >= 'A' && c <= 'Z'
                || c >= 'a' && c <= 'z'
                || c == '_' || c == '-'
                || c == '.' || c == '+'
                || c == '/';
    }
}

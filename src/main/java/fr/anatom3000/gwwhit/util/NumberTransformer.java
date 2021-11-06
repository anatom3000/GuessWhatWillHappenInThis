package fr.anatom3000.gwwhit.util;

import java.util.function.Function;

public class NumberTransformer {



    enum Transformer {

        ROMAN( RomanUtil::toRoman );

        private final Function<Integer, String> transformerFunc;

        Transformer( Function<Integer, String> transformerFunc ) {
            this.transformerFunc = transformerFunc;
        }

        public String apply(int num) {
            return this.transformerFunc.apply(num);
        }

    }
}

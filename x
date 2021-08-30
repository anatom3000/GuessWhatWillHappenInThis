#!/bin/bash
shopt -s expand_aliases
alias x=xdotool
alias  mm="xdotool mousemove "
nameval="<[a-zA-Z0-9_]*>"
mineroot="/home/lnee/.local/share/multimc/instances/me/.minecraft/"
combank=( "help" "ls" "test" "hhhhhhhhhh")
comdo=( "chat \"this is a help msg for eternaboch this a in beta so stuff may not work try &help &ls &test\"" "chat \"\$(ls)\"" "chat 3" "" )
boot(){
bu=1
trans=""

x windowmove $(x search Minecraft 2>/dev/null| tail -1) 0 0
mm 300 $((255+(50*$bu)))  
x click 1
 
mm 200 127  
x click 1 
mm 189 416 
x click 1 
 }
 chat(){
x type t
 x type "$1"
 x key Return
  
 }
readchat(){
cat "$mineroot/logs/latest.log" | grep -E "\\[[0-9:]*\\] \\[Render thread/INFO\\]: \\[CHAT\\]" | sed 's/ \[Render thread\/INFO\]: \[CHAT\] //g' |sed 's/\[VIP\] //g'
}
rech(){
readchat | tail -1
}
recy(){
rech | grep -E "$nameval" | sed '0,/\]/s//\n/' | tail -1 |sed '0,/> /s//\n/' | tail -1
}
rehead(){
recy | awk -F\& '{print $2}' 
}
rebody(){
recy | tail -c $(($(recy | wc -c)-$(recy | awk '{print $1}' | wc -c)+0))
}
p(){
:
}


while true
do
if [ "$si" != "$(readchat | tail -1)" ]
then
si="$(rech)"
echo "$si"
eval "recy $trans"
if [ "$(recy | head -c 1)" = "&" ] && [ "$(recy)" != "&" ]
then
eval ${comdo[$(($(echo "${combank[@]}" | tr ' ' '\n' | grep -n "$(rehead)" | tail -1 | awk -F: '{print $1}')-1))]}
fi
fi
done

program ejercicio2a; 
// Con RANDOMIZE corregido.
type 

lista = ^nodo;

nodo = record
dato:integer;
sig:lista;
end;

procedure agregarALaLista(var l:lista; num:integer);
var 
 nuevo:lista;
 begin
  new(nuevo); 
  nuevo^.dato := num; 
  nuevo^.sig := nil;
  if(l = nil)then 
  begin
   l := nuevo; 
  end
  else 
   begin
    nuevo^.sig := l;
    l := nuevo; 
   end;
 end;

procedure generarEnteros(var l:lista);
var  
 num:integer;
begin
  num := Random(101) + 100;
  while(num <> 100)do
  begin
   writeln('Numero aleatorio: ', num);
   readln; 
   agregarALaLista(l,num);
   generarEnteros(l);
  end;
end;

var
l:lista;
begin
l:= nil;
Randomize;
generarEnteros(l);
end.

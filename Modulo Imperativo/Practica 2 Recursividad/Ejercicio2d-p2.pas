program ejercicio2d; 

type 

lista = ^nodo;

nodo = record
dato:integer;
sig:lista;
end;

procedure minimoValor(l:lista; var min:integer);
 begin 
 if(l <> nil)then 
 begin
  if(l^.dato < min)then 
  begin
   min := l^.dato; 
  end; 
  l := l^.sig; // avanzo en la lista y achico el problema.
  minimoValor(l,min); // le paso la lista y el número minimo.
 end; 
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
  while (num <> 100)do // Si num = 100 , detener recursion
  begin
   writeln('Numero aleatorio: ', num);
   readln; 
   agregarALaLista(l,num);
   generarEnteros(l); // Vuelve a llamar a num y se genera el random
  end;
end;

var
l:lista;
min:integer;
begin
min := 9999;
l:= nil;
Randomize;
generarEnteros(l);
minimoValor(l,min);
end.

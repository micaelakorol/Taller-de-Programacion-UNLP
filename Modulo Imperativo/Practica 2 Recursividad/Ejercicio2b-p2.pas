program ejercicio2b; 
// Con randomize corregido y ejecutado.
type 

lista = ^nodo;

nodo = record
dato:integer;
sig:lista;
end;

procedure imprimirLista(l:lista); // Caso base: lista = nil o lista <> nil
begin
 if(l <> nil)then 
 begin
  write(l^.dato);
  l := l^.sig;
  imprimirLista(l); 
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
  while (num <> 100)do 
  begin
   writeln('Numero aleatorio: ', num);
   readln; 
   agregarALaLista(l,num);
   generarEnteros(l); // Vuelve a llamar a num y se genera el random
  end;
end;

var
l:lista;
begin
l:= nil;
Randomize;
generarEnteros(l);
imprimirLista(l);
end.

program ejercicio2c; 

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
  imprimirLista(l^.sig);
  write(l^.dato);  // el cumplirse el caso base, "desapila" y va imprimiendo en orden inverso.
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
  num := Random(101) + 100;  { genera entre 100 y 200 }
  while (num <> 100)do // Si num = 100 , detener recursion
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
imprimirLista(l);
end.

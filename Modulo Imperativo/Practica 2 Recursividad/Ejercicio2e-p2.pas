program ejercicio2e; 

type 

lista = ^nodo;

nodo = record
dato:integer;
sig:lista;
end;

procedure hallarValor(valor:integer; l:lista; var esta:boolean);
begin
  if(l <> nil)and(esta = false)then 
  begin
   if(l^.dato = valor)then
   begin
    esta := true; 
   end;
   l := l^.sig; 
   hallarValor(valor,l,esta);
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
   generarEnteros(l); // Vuelve a llamar a num y se genera el random
  end;
end;

var
l:lista;
valor:integer;
esta:boolean;
begin
esta:=false;
valor:= 60;
l:= nil;
Randomize;
generarEnteros(l);
hallarValor(valor,l,esta);
write('¿El valor', valor, 'existe en la lista?', esta);
end.

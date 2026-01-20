program ejercicio3;

type

pelicula = record 
cod:integer;
codGenero:1..8;
puntaje:real;
end;

pelicula2 = record
cod:integer;
puntaje:real;
end;

lista = ^nodo;

nodo = record
dato:pelicula2; 
sig:lista;
end;

listaDoble = record
primero:lista;
ultimo:lista;
end;

vector = array [1..8] of listaDoble;

vGenero = array [1..8] of integer;


procedure leerPeliculas(var p:pelicula);
begin
 write('Cod:');
 read(p.cod);
 if(p.cod <> -1) then
 begin
  write('Cod Genero');
  read(p.codGenero);
  write('Puntaje');
  read(p.puntaje);
 end;
end;


{Lo recibe como una lista porque es un array de lista ejemplo, recibe v[1] la lista 1, donde vamos a insertar atrás}
{v[p.codGenero]}
procedure agregarAtras(var l:listaDoble; peli2:pelicula2); 
var 
 nuevo:lista; {1. porque creamos un nuevo NODO --> nuevo:lista es lo que vamos a enlazar}
 begin 
  new(nuevo);
  nuevo^.dato := peli2;
  nuevo^.sig := nil;
  if(l.primero = nil) then 
   begin
   {2. Luego, ese nodo lo insertás dentro de la listaDoble (enlazándolo desde primero o ultimo).}
    l.primero := nuevo;
    l.ultimo := nuevo;
   end  
   else 
    begin
     l.ultimo^.sig := nuevo;
     l.ultimo := nuevo;
    end;
 end;

procedure cargarPeliculas(var v:vector);
var 
 p:pelicula;
 peli2:pelicula2;
begin 
 leerPeliculas(p);
 while(p.cod <> -1) do 
 begin 
  peli2.cod := p.cod;
  peli2.puntaje := p.puntaje;
  agregarAtras(v[p.codGenero],peli2); 
  leerPeliculas(p);
 end;
end;

procedure inicializarVector(var v:vector);
var 
i:integer;
begin 
  for i := 1 to 8 do 
  begin
  v[i].primero := nil;
  v[i].ultimo := nil;
  end;
end; 

procedure recorrerLista(cod:integer; var vGen:vGenero; l:lista);
var 
 max:real;
 codPelicula:integer;
begin 
 max := -1;
 while(l <> nil)do 
 begin 
  if(l^.dato.puntaje > max)then
  begin
   max := l^.dato.puntaje;
   codPelicula := l^.dato.cod;
  end;
  l := l^.sig;
 end;
  vGen[cod] := codPelicula; {le carga el > codigo de la pelicula}
end;

procedure recorrerVgenero(var vGen:vGenero; v:vector);
var 
 i:integer;
 begin
  for i := 1 to 8 do 
  begin
   recorrerLista(i, vGen, v[i].primero);

  end; 
 end;
 

 procedure ordenarVectorGenero(var vGen:vGenero);
 var 
  i,j,actual:integer; // actual:tipoElem que vamos a insertar/ordernar.
  begin
  for i := 2 to 8 do
  begin
   actual := vGen[i];
   j := i -1; { // j apunta al elemento anterior} //compara hacia atrás desde su posición.
  {> a <}
   while(j > 0) and (vGen[j] > actual)do 
   begin
    {lo que esta en la pos 2 pasa a la 1}
    vGen[j+1] := vGen[j]; 
    j:= j - 1; // retrocede para seguir comparando
   end;
   vGen[j+1] := actual; // inserta el valor en la posición correcta
  end;
 end;

 procedure hallarMenorCod(vGen:vGenero);
 var 
  i,minCod:integer;
  begin
   minCod := 9999;
   for i := 1 to 8 do 
   begin
    if(vGen[i] < minCod)then
    begin
      minCod := vGen[i];
    end; 
   end; 
   write('El menor cod es;', minCod);
  end;
 
 
var
v:vector; {declaro el vector de listas}
vGen:vGenero;
begin
inicializarVector(v);
cargarPeliculas(v);
recorrerVgenero(vGen,v); 
ordenarVectorGenero(vGen);
 write('El menor cod es;', vGen[1]);
 write('El mayor cod es;', vGen[8]); 
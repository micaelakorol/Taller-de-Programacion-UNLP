program ejercicio4;

const

dimF = 20; 

type

producto = record 
cod:integer;
rubro:1..6;
precio:real;
end;

lista = ^nodo;

nodo = record
dato:producto;
sig:lista;
end;

vector = array [1..6] of lista;

vProductos = array [1..dimF] of producto;

procedure recorrerLista(l:lista); // recorre cada codigo
begin
 while(l <> nil)do 
 begin
  write(l^.dato.cod);
  l := l^.sig; // avanza en la lista. 
 end; 
end;


procedure mostrarCodigos(v:vector);
var 
 i:integer;
 begin
  for i := 1 to 6 do
  begin
   writeln('Rubro ', i, ':');
   recorrerLista(v[i]); // envia el array de listas. En la primera vuelta, se envia la lista 1 v[1] y se recorre,
  end;
 end;


procedure inicializarVector(var v:vector);
var 
 i:integer;
 begin
  for i := 1 to 6 do
  begin
   v[i] := nil;  // todas las listas comienzan vacías. La lista de ese rubro está vacía.
  end; 
 end;
 
 procedure leerProducto(var p:producto);
 begin
  read(p.precio);
  if(p.precio <> -1) then
  begin 
   read(p.rubro);
   read(p.cod);
  end; 
 end;
 
 procedure insertarOrdenado(var l:lista; p:producto);
  var
  nue: lista; 
  act, ant: lista; {punteros auxiliares para recorrido}
 begin
 new (nue); 
 nue^.dato := p; 
 act := L; {ubico act y ant al inicio de la lista}
 ant := L;
 while( act <> nil)and(p.cod > act^.dato.cod)do 
 begin
  ant := act;
  act:= act^.sig;
 end;
 if (act = ant) then {al inicio o lista vacía}
  L:= nue
 else {al medio o al final}
  ant^.sig:= nue;
  nue^.sig:= act;
 end;
 
 procedure cargarProductos(var v:vector);
 var 
  p:producto;
  begin
   leerProducto(p);
   while(p.precio <> -1)do
   begin
    insertarOrdenado(v[p.cod],p); 
    leerProducto(p);
   end; 
  end;
  
 
  procedure cargarProductosV(l:lista; var vProdRubro3: vProductos; var dimL:integer);

  begin
   dimL := 0;
   while(l <> nil) and (dimL > dimF) do 
   begin
    dimL := dimL +1;
    vProdRubro3[dimL] := l^.dato; // // guardamos el producto en el vector
    l := l^.sig; // avanzo. 
   end; 
  end;
  
// d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos métodos vistos en la teoría.  
 
 procedure ordenarVector(var vProdRubro3:vProductos; dimL:integer);
 var 
  i,j:integer;
  actual:producto;
  begin 
   for i := 1 to dimL do 
   begin
     actual := vProdRubro3[i]; // actual es solo el elemento i
     j := i - 1;
     // aca se agrega el actual.precio (pq va ordenado por precio)
     while(j > 0) and (vProdRubro3[j].precio > actual.precio)do 
     begin
      vProdRubro3[j+1] := vProdRubro3[j];
      j := j - 1; 
     end;
     vProdRubro3[j+1] := actual;
   end;
  end; 
  
// e. Muestre los PRECIOS del vector resultante del punto d). 
 
 procedure mostrarPrecios(vProdRubro3:vProductos; dimL:integer); 
 var 
  i:integer;
  begin
   for i := 1 to dimL do 
   begin 
    write('Precios del rubro 3: ', vProdRubro3[i].precio);
   end; 
  end;
  
 // f.Calcule el promedio de los precios del vector resultante del punto d). 
 // Sumar todos los elementos del vector, y dividirlos por la dimL.
 
 function calcularPromedio(vProdRubro3:vProductos ; dimL:integer):real;
 var 
  suma,prom:real;
  i:integer;
  begin
   suma := 0; 
   prom := 0;
    for i := 1 to dimL do 
    begin
     suma := suma + vProdRubro3[i].precio; // Suma todos los precios.
    end; 
    prom := suma / dimL; // suma / total de elementos
    calcularPromedio := prom;
  end;
 
 // -------------- Adicional de práctica: calcular porcentaje de productos del rubro 3 superan los $500:
 
 function calcularPorcentaje(vProdRubro3:vProductos; dimL:integer):real;
 var
  i,cont,precioMin:integer;
  begin
   precioMin := 500; 
   cont := 0;
   for i := 1 to dimL do 
   begin
    if(vProdRubro3[i].precio > precioMin)then
    begin
     cont := cont + 1; 
    end; 
   end;
   calcularPorcentaje := (cont / dimL) * 100
   // Contar cuantos productos superan el minimo / dividido el total de productos * 100.
  end;
 
 
var 
v:vector; // Vector de listas.
vProdRubro3: vProductos; 
dimL:integer;
begin 
inicializarVector(v);
//inicializarVRubro3(vProdRubro3);
cargarProductos(v);
mostrarCodigos(v);
// Cargo max 20 productos del rubro 3 en el vector vProductos.
cargarProductosV(v[3],vProdRubro3,dimL); // Le enviamos v[3] = lista 3 porque solo se recorre ese rubro.
ordenarVector(vProdRubro3,dimL);
mostrarPrecios(vProdRubro3,dimL);
calcularPromedio(vProdRubro3,dimL);
end.

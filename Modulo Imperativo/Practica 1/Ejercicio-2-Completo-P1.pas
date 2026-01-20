program ejercicio1;

const 
dimF = 5;
type 

 oficina = record
  cod:integer;
  dni:integer;
  valor:real;
 end;
 
 vector = array[1..dimF] of oficina;
 
procedure leerOficina(var o: oficina);
begin
  write('Codigo de oficina (-1 corta): ');
  readln(o.cod); {leé el cod de la oficina}
  if (o.cod <> -1) then
  begin
    write('DNI del propietario: ');
    readln(o.dni);
    write('Valor de expensa: ');
    readln(o.valor);
  end;
end;


 procedure cargarVector(var v:vector; var dimL:integer);
 var 
  o:oficina;
  begin
   dimL:=0;
   leerOficina(o); 
   while(o.cod <> -1)and (dimL < dimF)do
   begin
    dimL := dimL + 1; 
    v[dimL] := o; 
    leerOficina(o);
   end; 
  end;

{Ordeno aplicando el metodo de insercion, por código de identificación de la oficina}
 procedure insercion(var v:vector; dimL:integer);
 var 
  i,j:integer;
  actual:oficina;
  begin
   for i := 2 to dimL do 
   begin
    actual := v[i]; 
    j := i - 1; 
   end;
    {Ordenamos por cod}
    while(j > 0) and (v[j].cod > actual.cod) do {La primera posicion es > 0? y lo que esta en la 1° pos es mayor a lo que esta en la 2°?}
    begin 
     v[j+1] := v[j]; {Lo que esta en la 2° pos lo pasamos a la primera}
     j := j- 1;
    end;  
    v[j+1] := actual; 
   end;
   
   {Ordeno aplicando el metodo de selección, por código de identificación de la oficina}
   {Este metodo, recorre todo el vector cada vez que compara}
   {En cada vuelta buscamos el mínimo cod en el resto del vector y lo intercambiamos con la posición actual.}
procedure seleccion(var v: vector; dimL: integer);
var
  i, j, pos: integer;
  item: oficina;
begin
  for i := 1 to dimL-1 do {comienza de 1 a la dimL-1 , porque el ult elemento se considera ordenado.}
  begin
    pos := i;  {suponemos que el mínimo está en i}
    for j := i+1 to dimL do {compara ESA pos con cada elemento del array}
    begin
      if v[j].cod < v[pos].cod then {Si la posicion actual es menor a la posicion POS}
        pos := j;  {actualizamos posición del mínimo}
    end;
    { intercambiamos una sola vez después de encontrar el mínimo }
      item := v[i];
      v[i] := v[pos];
      v[pos] := item;
  end;
end;

var
v: vector; 
dimL: integer;
begin
  cargarVector(v, dimL);  
  insercion(v,dimL);
end.

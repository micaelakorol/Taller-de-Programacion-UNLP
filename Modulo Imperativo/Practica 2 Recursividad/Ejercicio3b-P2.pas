program ejercicio3b;

type
vector = array [1..20] of integer;


procedure imprimirVectorRecursivo(v:vector; dimL:integer);
begin
  if(dimL > 0)then 
  begin
   imprimirVectorRecursivo(v,dimL-1); // Para imprimir en orden, primero llamo a la recursion
   write(v[dimL]); // Cuando sale de la recursion, empieza a ejecutarse lo que estaba pendiente en cada llamada:
   // v[1], v[2], etc...
  end;
end;

procedure ordenarVector(var v:vector; dimL:integer);
var 
 actual,i,j:integer;
 begin
 for i := 2 to dimL do 
 begin
   actual := v[i]; // Guardo la pos 2 o actual
   j := i - 1;  // Guardo la pos 1 o anterior
   while(j > 0)and(v[j] > actual)do
   begin
    v[j+1] := v[j];
    j := j - 1; 
   end;
   v[j+1] := actual;
 end
 end;


procedure cargarVectorRecursivo(var v:vector;i:integer;dimL:integer);
var 
 num:integer; // para el random
 begin
  num := Random(1550-300+1) + 300; 
  if(i <= dimL)then // Si esto se cumple, se corta la recursión
  begin
   v[i] := num;
   cargarVectorRecursivo(v,i+1,dimL);
  end;
 end;



var
v:vector;
i:integer;
dimL:integer;
begin
dimL := 20;
i:= 1;
//inicializar sus posiciones a 0.
Randomize;
cargarVectorRecursivo(v,i,dimL);
ordenarVector(v,dimL);
imprimirVectorRecursivo(v,dimL);
end.

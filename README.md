https://github.com/Javier1609/casofinalintegrador_tema5.git


La clase CONTEO_GENES tiene un método estático llamado countGenes que cuenta el número de veces que aparece el codón "ATG" en una cadena de ADN. Este método toma una cadena de ADN y un índice como parámetros. Verifica si hay suficientes nucleótidos restantes para formar un codón y si el codón actual es "ATG". Si es así, incrementa el contador y avanza al siguiente codón. Si no, avanza al siguiente nucleótido. Este proceso continúa recursivamente hasta que se examinan todos los nucleótidos, devolviendo el número total de codones "ATG" encontrados.

La clase COMBINACIONES_GENETICAS tiene dos métodos estáticos para calcular el coeficiente binomial: calcularCombinacionesRecursivo y calcularCombinacionesIterativo.

calcularCombinacionesRecursivo utiliza un enfoque recursivo para calcular el coeficiente binomial, siguiendo la identidad matemática C(n, k) = C(n-1, k-1) + C(n-1, k). Retorna 1 si k es 0 o igual a n, de lo contrario, llama recursivamente al método.
calcularCombinacionesIterativo utiliza un enfoque iterativo que llena una matriz C de tamaño (n+1) x (k+1) y calcula los valores basándose en la misma identidad matemática. Retorna C[n][k]. Ambos métodos proporcionan el mismo resultado, pero el enfoque iterativo suele ser más eficiente ya que evita la sobrecarga de las llamadas recursivas.
En el package de Herramientas de Análisis Numérico aparecen las clases Sumatoria_Listado_Numeros y Calculo_Potencias_maximos.

La clase SUMATORIA_LISTADO_NUMEROS tiene varios métodos para operar en listas de números enteros:
calcularSumatoria(int n): Calcula la suma de todos los números desde n hasta 1 de manera recursiva. Retorna 0 si n es menor o igual a 0, de lo contrario, retorna n más la suma de los números desde n-1.
listarNumeros(int inicio, int fin): Genera una lista de números enteros desde inicio hasta fin de manera recursiva. Retorna una lista vacía si inicio es mayor que fin, de lo contrario, retorna una llamada recursiva con fin decrementado y agrega fin a la lista resultante.
ordenarNumeros(int inicio, int fin): Genera una lista de números enteros desde inicio hasta fin y la ordena usando el algoritmo de ordenación rápida (QuickSort) con el método ordenarNumerosRecursivo.
ordenarNumerosRecursivo(List numeros, int inicio, int fin): Implementa el algoritmo de ordenación rápida recursivamente. Selecciona un pivote y hace llamadas recursivas para ordenar las sublistas alrededor del pivote.
partition(List numeros, int inicio, int fin): Implementa una parte del algoritmo de ordenación rápida. Selecciona un pivote y reordena la lista de tal manera que los elementos menores que el pivote estén a su izquierda y los mayores estén a su derecha. Devuelve el índice del pivote en la lista reordenada.
La clase CALCULO_POTENCIAS_MAXIMOS tiene varios métodos para realizar operaciones matemáticas y de listas:
calcularPotencia(int base, int exponente): Calcula la potencia de un número. Inicializa un resultado a 1 y multiplica la base por sí misma según el exponente en un bucle, decrementando el exponente en cada iteración. Retorna el resultado.
encontrarMaximo(List numeros): Encuentra el número máximo en una lista de números enteros. Inicializa el máximo al primer número de la lista y luego recorre la lista, actualizando el máximo si encuentra un número mayor. Retorna el máximo.
ordenarNumeros(List numeros): Ordena una lista de números enteros utilizando el algoritmo de ordenación rápida (QuickSort). Divide la lista en sublistas basadas en un pivote y ordena recursivamente estas sublistas antes de combinarlas. Retorna la lista ordenada.
calcularPotenciasYEncontrarMaximo(int base1, int exponente1, int base2, int exponente2, int base3, int exponente3): Calcula las potencias de tres pares de base y exponente utilizando calcularPotencia, coloca los resultados en una lista y luego encuentra el máximo de estos resultados utilizando encontrarMaximo. Retorna el máximo encontrado.
El package Gestion_Informacion_Cientifica esta formado por las clases Organizacion_Documentos, Busqueda_Eficiente_Textos y Gestion_Fechas.

La clase ORGANIZACION_DOCUMENTOS ofrece métodos para operaciones de lectura, escritura y ordenamiento en archivos y cadenas de texto:
sortAndWriteLines(ArrayList lines, String outputPath): Ordena una lista de cadenas de texto en orden alfabético utilizando Collections.sort y escribe las líneas ordenadas en un archivo de salida, una por una.
sortLines(String inputFilePath, String outputFilePath): Lee todas las líneas de un archivo de entrada en una lista, luego para cada línea, ordena las palabras alfabéticamente utilizando sortWordsInLine y 3. agrega la línea ordenada a una nueva lista. Finalmente, escribe las líneas ordenadas en un archivo de salida.
sortWordsInLine(String line): Divide una cadena de texto en palabras, las ordena alfabéticamente y las une nuevamente en una sola cadena, separadas por espacios. En resumen, la clase proporciona una funcionalidad para leer un archivo de texto, ordenar las palabras en cada línea y escribir las líneas ordenadas en un nuevo archivo.
La clase BUSQUEDA_EFICIENTE_TEXTOS proporciona métodos para realizar operaciones de búsqueda y ordenamiento en archivos de texto:
busquedaLineal(String rutaArchivo, String palabra): Realiza una búsqueda lineal de una palabra en un archivo de texto, leyendo el archivo línea por línea y verificando si cada línea contiene la palabra. Retorna true si la palabra se encuentra y false si no.
busquedaBinaria(String rutaArchivo, String palabra): Realiza una búsqueda binaria de una palabra en un archivo de texto. Lee todas las líneas del archivo en una lista, las ordena usando el algoritmo de ordenamiento por mezcla (mergeSort) y luego realiza una búsqueda binaria en la lista ordenada. Retorna true si la palabra se encuentra y false si no.
leerLineas(String rutaArchivo): Método privado que lee todas las líneas de un archivo de texto en una lista y devuelve la lista de líneas.
mergeSort(List lineas): Método privado que ordena una lista de líneas de texto utilizando el algoritmo de ordenamiento por mezcla. Divide la lista en dos mitades, ordena cada mitad recursivamente y luego combina las dos mitades ordenadas en una sola lista ordenada.
merge(List left, List right): Método privado que combina dos listas ordenadas en una sola lista ordenada. Itera sobre ambas listas al mismo tiempo y agrega el elemento más pequeño en cada paso, luego agrega los elementos restantes de una lista cuando la otra se agota. En resumen, la clase proporciona funcionalidades para buscar eficientemente palabras en un archivo de texto, ya sea mediante búsqueda lineal o búsqueda binaria, y también para ordenar las líneas del archivo utilizando el algoritmo de ordenamiento por mezcla.
La clase GESTION_FECHAS ofrece métodos para operar en una lista de fechas (LocalDate):
agregarFecha(LocalDate fecha): Agrega una fecha a la lista de fechas.
listarFechas(): Ordena la lista de fechas utilizando el algoritmo de ordenamiento por mezcla (mergeSort) e retorna la lista ordenada.
mergeSort(List fechas): Método privado que ordena una lista de fechas utilizando el algoritmo de ordenamiento por mezcla. Divide la lista en dos mitades, ordena cada mitad recursivamente y luego combina las dos mitades ordenadas.
merge(List left, List right): Método privado que combina dos listas ordenadas de fechas en una sola lista ordenada, iterando sobre ambas y agregando la fecha más temprana en cada paso. En resumen, la clase proporciona funcionalidades para gestionar una lista de fechas, agregar nuevas fechas a la lista y obtener la lista de fechas ordenada.
En el package Optimizacion_Procesos aparece la clase Mejora_Algoritmos (que consta de una implementación de código del metodo 'quicksort').

La clase MEJORA_ALGORITMOS implementa y mejora el algoritmo de ordenamiento QuickSort:
quickSort(int[] arr, int low, int high, boolean ascendente): Implementa el algoritmo QuickSort. Realiza una partición del array utilizando el método partition y luego realiza llamadas recursivas para ordenar las dos mitades del array. Si es la primera vez que se ordena el array, imprime el array utilizando printArrayWithDelay.
partition(int[] arr, int low, int high, boolean ascendente): Implementa la partición del algoritmo QuickSort. Selecciona un pivote utilizando medianOfThree, reordena el array para que los elementos menores (o mayores, según ascendente) estén a la izquierda del pivote y los mayores (o menores) a la derecha. Retorna el índice del pivote en el array reordenado.
printArrayWithDelay(int[] arr): Imprime el array y hace que el hilo actual duerma durante 1500 milisegundos. Si el hilo se interrumpe durante el sueño, muestra un mensaje de error.
medianOfThree(int[] arr, int low, int high): Implementa la elección del pivote como la mediana de tres elementos: el primero, el último y el del medio. Reordena estos elementos en el array para que el del medio (la mediana) sea el último, el menor sea el primero y el mayor sea el segundo. Retorna el índice del pivote (la mediana) en el array reordenado.
swap(int[] arr, int i, int j): Intercambia dos elementos en el array dado dos índices. En resumen, la clase proporciona una implementación del algoritmo QuickSort junto con mejoras como la elección de la mediana de tres elementos como pivote y la impresión del array con un retraso.
Todas las clases explicadas anteriormente son utilizadas para la definición de código necesaria para cumplir con lo requerido. Esta implementación de código es compilada y mostrada al usuario por una clase 'Main' que muestra la ejecución de dicho código. Esta clase no esta definida en ningún package porque no es necesario. Sin embargo con los diversos imports añadidos, utiliza el código de las demás clases de los diferentes package para su ejecución.

La clase MAIN en el archivo es una aplicación de escritorio en Java que utiliza Swing para la interfaz de usuario.
En el método main, se crea un nuevo JFrame que actúa como la ventana principal de la aplicación. Se establece el tamaño de la ventana y se agrega un JPanel a la ventana.
Se llama al método placeComponents que configura el panel principal. Este método crea varios componentes de la interfaz de usuario, incluyendo un JLabel para el título, un JComboBox para seleccionar opciones, y dos JButton para confirmar la selección y salir de la aplicación.
Se crean instancias de varias clases que se utilizarán para realizar diferentes operaciones basadas en la opción seleccionada en el JComboBox.
Se añaden ActionListener a los botones. El botón de confirmación tiene un ActionListener que realiza diferentes acciones basadas en la opción seleccionada en el JComboBox. Estas acciones incluyen contar genes, calcular combinaciones genéticas, calcular potencias y encontrar el máximo, calcular sumatorias, agregar y listar fechas, ordenar documentos, buscar palabras y ejecutar el algoritmo quicksort.
El botón de salida tiene un ActionListener que cierra la aplicación cuando se hace clic en él.
Finalmente, se hace visible la ventana principal de la aplicación en la que aparecen las diferentes opciones a elegir.

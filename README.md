
                                                  Sistema de Reparto de Productos
                                                        
Una empresa que se dedica al reparto de productos a escala nacional requiere un sistema que le permita registrar su actividad y decidir algunas rutas a seguir.
El sistema deberá estar desarrollado en JAVA usando interfaz gráfica es indispensable desarrollar una etapa de análisis y diseño que facilite la construcción de diagramas fundamentales como el diagrama de clases.

    1.- Datos que se manejan en el sistema:

    El sistema requiere manejar datos sobre:
    
                      * Ciudades
                      * Productos
                      * Clientes
                      * Características especiales
                      * Empresa
                      * Vehículos
                      * Conductores

1.1.- Ciudades:

Las ciudades son los nodos de un grafo en el que se presta el servicio de transporte. Una ciudad se enlaza a una o varias ciudades por medio de un camino. De una ciudad se requiere su nombre, ubicación (coordenada en un plano x, y. Para simplificar el problema asumiremos un plano con coordenadas desde 0 hasta 100 en ambos ejes), y el conjunto de ciudades a las que se enlaza. Cada enlace representa un tiempo de viaje entre una ciudad y otra. El tiempo de viaje estará en minutos y será un entero positivo. Es posible realizar todas las operaciones CRUD sobre ciudades, pero no podrán eliminarse ciudades que tengan un viaje pendiente por ejecutarse, o clientes con oficinas en dicha ciudad.


1.2.- Productos:

En un viaje se transportan distintos tipos de productos. Se debe generar un mantenimiento para productos. De un producto se conoce su nombre, las características especiales de transportación (por ejemplo, si requiere aire acondicionado. Se creará una característica especial llamada NINGUNA), su unidad (fundas, cajas, quintales, etc), el peso (kg) por unidad y el volumen (m3) por unidad.
No se pueden eliminar productos que intervengan en un viaje que no ha concluido. No se pueden crear productos con una característica especial que no exista en el sistema.


1.3.- Clientes:

Los clientes tienen negocios en una o más ciudades. De un cliente se conoce su nombre, dirección, teléfono, correo de contacto y ciudades en las que tienen sus negocios. Se podrán ejecutar todas las operaciones CRUD sobre clientes.  No se podrán eliminar clientes que hayan contratado alguna vez un servicio.


1.4.- Características Especiales:

Un producto se transporta bajo ciertas características especiales, por ejemplo, congelador, en cerchas, en tanqueros, etc. El sistema debe permitir crear características especiales de las que se conoce un nombre de la característica y una descripción. Todas las operaciones CRUD podrán ejecutarse sobre este tipo de datos.
Las características especiales se asocian a los productos y a los vehículos. Si un producto tiene asociada una característica especial esa, no podrá ser eliminada.


1.5.- Empresa:

Se podrán manejar datos relacionados a la empresa de reparto, por ejemplo: Ciudad en la que tiene oficinas, Dirección y teléfono. Toda operación CRUD es permitida en este tipo de datos


1.6.- Vehículos

Hay diferentes vehículos en la empresa, cada vehículo tiene placa, marca, modelo, ciudad en la que reside, peso máximo que transporte, volumen máximo que transporte y un conjunto de características especiales. Se podrá crear Vehículos y consultarlos. La consulta mostrará todos los datos asociados al vehículo.


1.7.- Conductores

La empresa tiene varios conductores contratados, cada conductor tiene un nombre, cédula, y ciudad en la que reside. Se pueden crear conductores (no otra operación crud).

    2.-  Transacciones
    
El sistema permite definir ciertas transacciones que se describen a continuación:


2.1.- Contratar viaje

Un cliente alquila un viaje para transportar un conjunto de productos de una ciudad a otra. De un viaje se conoce: el cliente que contrata el viaje, ciudad origen, ciudad destino, fecha de entrega (fecha en la que los productos deben llegar al destino) y productos. Sobre los productos (un mismo viaje puede transportar más de un tipo de productos) se debe solicitar el producto, la cantidad de productos y con ello calcular el peso, volumen total y conocer las características especiales de los productos. 
Cuando se contrata un viaje el sistema deberá verificar si es posible realizar el viaje conforme lo solicitado y la disponibilidad de la flota. La verificación consta de:

        * Verificar que exista un vehículo disponible para la fecha de entrega que tenga la capacidad para transportar los productos deseados.
        * Verificar que exista enlace entre las ciudades de origen y destino.
        
Si la verificación es exitosa el viaje se contrata, de otra forma se cancela automáticamente. Los clientes pueden arrepentirse y cancelar el viaje, por lo que el sistema deberá permitir la cancelación.


2.2.- Visualizar cobertura

En función de las coordenadas x y y de las ciudades, dibuje en un plano cartesiano la ubicación de las ciudades y los enlaces entre ellas.


    3.- Reportes
      
Se deberá presentar un reporte (listado de todos los objetos de ese tipo) de:
Vehículos, ordenados por placa

        * Viajes contratados, ordenados por fecha
        * Viajes contratados ordenados por ciudad destino
        * En los reportes se podrá seleccionar el método de ordenamiento: MergeSort, QuickSort o HeapSort

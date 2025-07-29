+++
title = "Política de privacidad"
[extra]
go_to_top = false
+++
_Modificado por última vez el: 25 ago. 2022_

FlorisBoard (el "Proyecto") es un teclado libre que respeta la privacidad, desarrollado y mantenido principalmente por Patrick Goldinger ([@patrickgold](https://github.com/patrickgold)) y Lars Mühlbauer ([@lm41](https://github.com/lm41)), junto al increíble apoyo de la comunidad de este proyecto. Esta política de privacidad existe para darte un mejor entendimiento de los datos a los que se debe de acceder y/o almacenar localmente por lo menos para proveerte con un servicio de teclado.

## Acceso y uso a los datos

El compromiso principal de este proyecto es acceder y almacenar a los mínimos datos personales posibles mientras que se provee una buena experiencia personalizada. Cualquier datos personales a los que se acceda o que se almacenen se mantienen exclusivamente localmente,!ªQ en memoria o en el directorio de datos privados de la aplicación, y **nunca** se comparten con nadie.

### ¿A qué datos personales accede FlorisBoard y por qué?

En cualquier momento que enfoques una área de texto y FlorisBoard sea el método de entrada por defecto (el "IME"), FlorisBoard tiene acceso a los contenidos completos de esa área de texto. Monitorizará y almacenará una pequeña ventana alrededor del cursor en memoria para ayudar a hacer un seguimiento del estado actual y mejorar el rendimiento. Adicionalmente, como un IME por defecto, FlorisBoard tiene acceso al portapapeles del sistema y lo monitoriza para proveerte con las características del portapapeles. Más allá, FlorisBoard tiene acceso al diccionario de usuario del sistema, aunque solo leyendo los contenidos si la comprobación ortográfica, las sugerencias, o la escritura por deslizamiento están activadas.

A menos que enuncie de otra manera en la siguiente sección, cualquiera de los datos personales a los que se acceda solo se almacenan temporalmente en memoria, y se descartarán cuando el campo de texto pierda el enfoque o el proceso del teclado termine.

### ¿Qué datos personales guarda FlorisBoard y por qué?

Algunas de las características requieren datos personales que se persistan de manera local en el disco, para poder ser reutilizados más tarde. Esto se aplica a:

- **Comprobación ortográfica, sugerencias y escritura por deslizamiento**
  Para poder crear diccionarios personales automáticamente y proveer sugerencias dinámicas basadas en tus entradas anteriores, FlorisBoard tiene que monitorizar tu comportamiento de escritura, aprender de él y guardar los resultados localmente. El monitorizado del comportamiento de escritura se para completamente si el teclado está en modo incógnito, o si no hay ninguna característica habilitada que requiera esta opción.
- **Historial del portapapeles**
  Para poder almacenar y mostrar múltiples ítems del portapapeles, FlorisBoard almacena los ítems del portapapeles en una base de datos local. La base de datos solo se mantiene y se usa si la característica de historial del portapapeles está habilitada.

### ¿Alguno de los datos personales almacenados deja el dispositivo?

No. Cualquier dato personal que persista se almacena localmente y **nunca** deja tu dispositivo.

## Otro

Para información sobre la lista de permisos pedidos por FlorisBoard, por favor, lee [este](https://github.com/florisboard/florisboard/wiki/List-of-permissions-FlorisBoard-requests) documento.

### Actualizaciones de esta política de privacidad

Nos reservamos el derecho de revisar y actualizar esta política periódicamente. Los cambios a está política se anunciarán públicamente y se enlazarán en el correspondiente conjunto de cambios de la versión en la que la nueva política tome efecto. El uso continuado de FlorisBoard se considerará la aceptación de esos cambios.

### Contacto

Si tienes preguntas adicionales, comentarios o preocupaciones con respecto a esta política de privacidad, por favor ponte en contacto con [patrick@patrickgold.dev](mailto:patrick@patrickgold.dev) o presenta una incidencia en el [gestor de incidencias](https://github.com/florisboard/florisboard/issues) de FlorisBoard.


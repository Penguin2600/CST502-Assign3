===Team Members===
Charles Bock
Jason Taylor
Brandon Zimmerman

===Platform===
Debian Linux (GNUStep)

===How to Run===
From the Project Directory:
$ant clean                  // clean up the environment
$ant build                  // builds dplc compiler in obj directory
$./obj/dplc  <my dpl file>  // compiles the dpl code into int code
$./java/dplx <my int file>  // execute the int code

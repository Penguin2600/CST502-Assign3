===Team Members===
Charles Bock
Jason Taylor
Brandon Zimmerman

===Platform===
Debian Linux (GNUStep)

===How to Run===
From the Project Directory:
$ant clean                  // clean up the environment
$ant builddplc              // builds dplc compiler in dplc directory
$ant builddplx              // builds dplx interpreter in dplx directory
$./dplc/dplc <my dpl file>  // compiles the dpl code into int code
$./dplx/dplx <my int file>  // execute the int code

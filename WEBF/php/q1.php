<?php

	$a=$_POST['t1'];
	echo "Multiplicatio table of ",$a," is\n\n";
	for($i=1;$i<10;$i++){
		echo "<br>";
		echo $a,"x",$i,"=",$a*$i;
	}

?>

<?php
echo "in function";
$arr=array('monday','tuesday','wednesday','thursday','friday','saturday','sunday');
$a=$_POST['txtnm'];
echo $a;
if($a>7)
	echo "not a day name";
else
	echo "day name is ".$arr[$a-1];
?>

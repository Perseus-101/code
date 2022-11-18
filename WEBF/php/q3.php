<?php

$number=$_POST['t1'];
if($number==0)
	echo"no is zero";
if($number<0)
	echo"\ngiven number is negative";
if($number>0)
{
	echo"\ngiven number is positive";
	if($number % 2 ==0)
	{
			echo"and even";
	}
	else
	{
		echo "and odd";
	}
}
?>

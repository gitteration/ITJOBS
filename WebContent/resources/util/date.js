function date_toString(date){
	var today=date;
	var year=today.getFullYear()
	var month=(today.getMonth()+1)<9?"0"+(today.getMonth()+1):(today.getMonth()+1);
	var day=today.getDate()<9?"0"+today.getDate():today.getDate();
	var str=year+"-"+month+"-"+day
	return str
}
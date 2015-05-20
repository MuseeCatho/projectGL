var arrayImage1 = new Array();
var arrayImage2 = new Array();
var arrayImage = new Array(arrayImage1, arrayImage2);

function hideEnr() {
	if ($('#buttonChange').val() == 'Proposer une modification') {
		$('#buttonChange').val('Terminer les modification');
		$('#carouselPhotos').toggle();
		$('#listPhotos').toggle();
		var e = document.getElementById('descriptionDetail_text');

		var d = document.createElement('textarea');
		d.innerText = e.innerText;
		
		e.parentNode.insertBefore(d, e);
		e.parentNode.removeChild(e);
		d.id="modif_text";
//		d.style.width='400px';
//		d.style.heigth='800px';
		//class="form-control" rows="3"
		//d.class="form-control";
		$('#modif_text').addClass("form-control");
		//d.rows="3";
		document.getElementById('modif_description').style.display="block";
		
	} else {
		var r = confirm("Confimer les modifications?");
		if (r == true) {
			SaveModif(arrayImage2);
			$('#buttonChange').val('Proposer une modification');
			arrayImage1 = [];
			arrayImage2 = [];
			$('#carouselPhotos').toggle();
			$('#listPhotos').toggle();
		}
	}
}

var text=document.getElementById('descriptionDetail_text').innerText;
var list_text=text.split(" ");
var list_text_insert;
var list_word_delete=[];
var list_string_insert=[];
var list_index_delete=[];
var list_word_delete_string;

function button(){
    var text_insert=document.getElementById('modif_text').value;
    list_text=text.split(" ");
    list_text_insert=text_insert.split(" ");
    var length_text_origin=list_text.length;
    var length_text_modified=list_text_insert.length;

    list_string_insert=[];
    list_word_delete=[];
    list_index_delete=[];
    list_word_delete_string=[];
    var count=0;
    var gap=0;//decalage du texte modifié
    var gap2=0;//decalage du texte d'origine
    for(var j=0; j<Math.max(length_text_origin,length_text_modified);j++){
        var pos_X=-1;
        if(list_text[j+gap2]!=list_text_insert[j+gap] && typeof list_text[j+gap2]!="undefined"){
            console.log(list_text[j+gap2]);
            console.log(list_text_insert[j+gap]);
            var k=j;
            var word_delete="";
            var first=1;
           
            while(pos_X==-1){//on devrait executer cette boucle que lorsqu'on est sûr qu'il s'agit d'une suppression
                //console.log(list_text[k+gap2]);
                pos_X=list_text_insert.indexOf(list_text[k+gap2],j+gap);//on cherche par exemple le mot "milieu" dans le texte modifié 
                //console.log("pos_X: "+pos_X);
                var notdoublon=false;
                if(pos_X==-1){//si le mot suivant dans list_text n'existe pas dans list_insert c'est qu'il a été supprimé donc il faut chercher le mot suivant

                    list_word_delete.push(k+gap2);//on stocke les mots supprimés
                    if(first==1)//pour une phrase supprimé on stocke l'indice de son premier mot
                        list_index_delete.push(k);//on ne rajoute pas gap2 car on list_index_delete stocke des indices pour la list list_text_insert et non list_text
                    word_delete+=list_text[k+gap2]+" ";
                    first++;
                    k++;
                    notdoublon=true;
                }
                else{//si on trouve le mot en question c'est qu'il y a deux possibilités, soit le mot trouvé est en réalité un autre mot et donc le mot en question à été supprimé soit il y eu insertion de mot 
                   
                    var list_of_doublon_index_text_modified = indexOfCount(list_text_insert,list_text[k+gap2],j+gap);
                    var list_of_doublon_index = indexOfCount(list_text,list_text[k+gap],j+gap2);
                    var doublon=false;
                    if(list_of_doublon_index_text_modified.length < list_of_doublon_index.length){//il y a forcement eu suppression du mot QUELQUE PART
                        console.log(list_of_doublon_index_text_modified);
                        console.log(list_of_doublon_index);
                        list_word_delete.push(k+gap2);//k+gap2=13
                        if(first==1)//pour une phrase supprimé on stocke l'indice de son premier mot
                            list_index_delete.push(k);
                        word_delete+=list_text[k+gap2]+" ";
                        first++;
                        doublon = true;
                        k++;
                        pos_X=-1;// on le met à -1 de maniere a rester dans la boucle for
                         
                    }
                    else{//dans ce cas ce n'est pas forcement une non suppression puisque l'utilisateur pourrait inserer du texte plus loin contenant le même mot
                        //console.log(list_of_doublon_index_text_modified);
                        //console.log(list_of_doublon_index);
                        notdoublon=true;
                    }
                    // pos_X=-1;
                    // break;

                }
                
                if((k+gap2)>list_text.length-1){
                    break;
                }

            }

            if(word_delete!="")//insertion des mots supprimés
                list_word_delete_string.push(word_delete);
            //ci dessous à modifier
            if(!doublon || notdoublon){
                for(var i=j+gap;i<pos_X;i++){//stocke à priori les indices des mots qui on été insérés
                    list_string_insert.push(i);
                    //console.log("i :"+i);
                
                }
            } 
     
            gap=list_string_insert.length;
            gap2=list_word_delete.length;//1
           // console.log("list_index_delete: "+list_index_delete.length+"count :"+count);
            // for(var i=count;i<list_index_delete.length;i++){
            //     console.log(list_index_delete[i]-gap);
            //     list_index_delete[i]=list_index_delete[i]-gap;
            // }
            if(list_index_delete.length-1==1)
                //console.log(list_index_delete[list_index_delete.length-1])
            if(word_delete!="")
                list_index_delete[list_index_delete.length-1]+=gap;

            //-------------------------------------------------------------------------------
            // pos_X=list_text_insert.indexOf(list_text[j],j+gap)-1;
            // for(var i=j+gap;i<=pos_X;i++){
            //      list_string_insert.push(i);
                
            // }
            // gap=list_string_insert.length;
            count++;
        }

        else if(typeof list_text[j+gap2]=='undefined'){

            list_string_insert.push(j+gap);

        }
    
    }

    var result="";
    //var list_index_delete=compact_list_num(list_word_delete);
    var index_word_delete;
    var word_delete_index=0;
    for(var k=0;k<list_text_insert.length;k++){
        index_word_delete=k;
        // index_word_delete=k;
        // if(list_word_delete.indexOf(index_word_delete)!=-1){
        //     while(list_word_delete.indexOf(index_word_delete)!=-1){
        //        result+='<s><span style="color:red">'+list_text[index_word_delete]+'</span></s>'+" ";
        //        console.log(list_text[index_word_delete]+" "+"index_word_delete: "+index_word_delete);
        //        index_word_delete++; 
        //     }
            
        // }
       
        if(list_index_delete.indexOf(k)!=-1){
            //  while(list_word_delete.indexOf(index_word_delete)!=-1){
            //    result+='<s><span style="color:red">'+list_text[index_word_delete]+'</span></s>'+" ";
            //    console.log(list_text[index_word_delete]+" "+"index_word_delete: "+index_word_delete);
            //    index_word_delete++; 
            // }
            result+='<s><span style="color:red">'+list_word_delete_string[word_delete_index]+'</span></s>'+" ";
            word_delete_index++;
        }
        if(list_string_insert.indexOf(k)!=-1){
            result+='<b><span style="color:green">'+list_text_insert[k]+'</span></b>'+" ";
        }
        else{
            result+=list_text_insert[k]+" ";
        }
    }
    result=document.getElementById('result').innerHTML=result;
}


function compact_list_num (list) {
    var new_list=[list[0]];
    for(var k=1;k<=list.length;k++){
        if(list[k]!=list[k-1]+1){
            new_list.push(list[k-1]);
        }
    }
    return new_list;
}

function indexOfCount (list, element, begin) {
    if (list.indexOf(element)==-1){
        return [];
    }

    // var hash={
    //     "indexes":[]
    // };
    var list_index=[];
    for(var j=begin; j<list.length;j++){
        if(list[j]==element){
            // hash["indexes"].push(j);
            list_index.push(j);
        }   
    }
    return list_index;
}

function addProposition(type, id, etat) {
	var today = new Date();
	var date = today.toLocaleDateString();
	if (type = 'image') {

		var r = confirm("Voulez-vous vraiment supprimer cette image?");
		if (r == true) {
			var id_audio = 0;
			var id_photos = id;
			var id_videos = 0;

			var id_enrichments = 1;
			var object = {
				"date" : date,
				"etat" : etat,
				"type" : type,
				"id_audio" : id_audio,
				"id_photos" : id_photos,
				"id_videos" : id_videos,
				"id_enrichments" : id_enrichments
			}
			arrayImage1.push(id_photos);
			arrayImage2.push(object);
		}

	}
}

function SaveModif(arrayImage2) {
	alert(arrayImage2)
	for (var int = 0; int < arrayImage2.length; int++) {
		$.ajax({
			url : 'addProposition.action',
			type : 'POST',
			encoding : "UTF-8",
			async : true,
			data : arrayImage2[int],
			success : function(data) {
			}
		});

	}
}
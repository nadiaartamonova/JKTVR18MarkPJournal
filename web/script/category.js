"use strict";

function status(response) {  
  if (response.status >= 200 && response.status < 300) {  
    return Promise.resolve(response)  
  } else {  
    return Promise.reject(new Error(response.statusText))  
  }  
}


function json(response){
    return response.json();
}


//СПИСОК ПОДКАТЕГОРИЙ 
// показывает список подкатегорий после выбора категории.
// categoryId отправляет в МайнСервлет кейс subCategoryList номер кагорию ид 
// и оттуда получает список подкатегорий subCategoryListByCategory
document.getElementById("category").onchange=function(){
    let categoryId = this.value;
    console.log(categoryId);
    
    //subcategory show
    document.getElementById("subCategoryListLabel").style.display="block";
    document.getElementById("subCategoryList").style.display="block";
    let url = 'subCategoryList?categoryId='+categoryId;
    fetch(url).then(status)  
          .then(json)
          .then(function(subCategoryListByCategory) {
                deleteOldSubCategory();
                printSubCategory(subCategoryListByCategory);
                console.log('Request succeeded with JSON response', subCategoryListByCategory);
                
          })
          .catch(function(error) {  
            console.log('Request failed', error);  
          });
    
     
    
    };

// Удаляет из списка подкагорий опции, убирая их индекс.
function deleteOldSubCategory(){
   for(; subCategoryList.length>0; ) {
    	subCategoryList.remove(subCategoryList.length-1);
   }
}    
   
function printSubCategory(subCategoryListByCategory) {
    let option = new Option(" ", " ");
        subCategoryList.append(option);
    for (let i in subCategoryListByCategory){
        //console.log(subCategoryListByCategory[i].subCategoryName, subCategoryListByCategory[i].id);
        let newOption = new Option(subCategoryListByCategory[i].subCategoryName, subCategoryListByCategory[i].id);
        subCategoryList.append(newOption);
    }
    //newOption.selected = true;
    
}

document.getElementById("subCategoryList").onchange=function(){
    let subCategoryId=this.value;
    console.log(subCategoryId);
    
    
}

document.getElementById("addStage").onclick=function(){
    
    let str = `
                    <div class="form-group row" style=" padding: 0;" id="stage">
                        <h5 style=" padding: 0;" class="col-sm-12">Этап: </h5>
                        <label class="col-sm-2 control-label" id="stageLabel" style=" padding: 0;">Наименование:  </label>
                        
                        <div class="col-sm-10" style=" padding: 0;">
                            <input type="text" class="form-control" name="stageName[]">
                        </div>
                        
                        
                        <label class="col-sm-2 control-label" id="stageLabel2" style=" padding: 0;">Описание этапа:</label>
                        <div class="col-sm-10" style=" padding: 0; margin-top: 17px;">
                            <textarea class="form-control"  name="stageDescription[]" rows="5"></textarea>
                        </div>
                        
                        
                    </div>
`
let stages = document.getElementById('stages');
stages.innerHTML+=str;
   // document.getElementById("index").append(index);
    //document.getElementById("stage").style.display="flex";
    
}

function newStage(){
    
}


  
  

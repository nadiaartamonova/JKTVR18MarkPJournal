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

//test data
let subCategoryListByCategory = [
    [1, 'Наклейки'],
    [2, 'Плакаты'],
    [3, 'Флаеры'],
    [4, 'Визитки'],
    [5, 'Дипломы']
];





// SHOW -- HIDE
document.getElementById("category").onchange=function(){
    let categoryId = this.value;
    console.log(categoryId);
    
    //subcategory
    document.getElementById("subCategoryListLabel").style.display="block";
    document.getElementById("subCategoryList").style.display="block";
           
    };
    
function printSubCategoryList(subCategoryListByCategory){
    let str='';
    for(let i in data){
        str += `
            <option value="" hidden=""></option>
            <option value="${data[1].subCategory.id}">${data[1].subCategory.Name}</option>
        `
    }
}    
document.getElementById("subCategoryList").innerHTML = str;



  
  

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
//let subCategory={'id':'subCategoryName'};
//
//let subCategoryListByCategory = [
//    {'0': 'Наклейки'},
//    {'2': 'Плакаты'},
//    {'3': 'Флаеры'},
//    {'4': 'Визитки'},
//    {'5': 'Дипломы'}
//];





// SHOW -- HIDE
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
                printSubCategory(subCategoryListByCategory);
                console.log('Request succeeded with JSON response', subCategoryListByCategory);
                
          })
          .catch(function(error) {  
            console.log('Request failed', error);  
          });
         
    };
    
//select SUBcategory print    
    function printSubCategory(subCategoryListByCategory) {
        
        //let selectedOption = subCategoryListByCategory.options[subCategoryListByCategory.selectedIndex];
               
        let option = new Option("","");
        subCategoryList.append(option);
        for (let i in subCategoryListByCategory){
          
          console.log(subCategoryListByCategory[i].subCategoryName, subCategoryListByCategory[i].id);
          let newOption = new Option(subCategoryListByCategory[i].subCategoryName, subCategoryListByCategory[i].id);
          
          subCategoryList.append(newOption);
        }

        newOption.selected = true;  
    }








  
  

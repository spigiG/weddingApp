window.onload = function () {
    updateTable();
    let foodForm = document.getElementById('food-form');
    foodForm.onsubmit = handleSubmit;
}

function handleSubmit(event) {
    
    let typeInput = document.querySelector('#food-type');
    let foodType = typeInput.value;

    let titleInput = document.querySelector('#food-name');
    let foodName = titleInput.value;

    let descInput = document.querySelector('#food-desc');
    let foodDesc = descInput.value;

    let food = {'foodType': foodType, 'foodName': foodName, 'foodDesc': foodDesc};
    let url = 'http://localhost:8080/api/foods';

    fetch(url, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Access-Control-Allow-Origin':'*',
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(food)
    })  
    .then(function (request) {
        updateTable();
        return request.json();
    })
      .then(function (jsonData) {

        let messageP = document.getElementById('message-p');
        messageP.innerHTML = 'Étel létrehozva.';

        typeInput.value = '';
        titleInput.value = '';
        descInput.value = '';   
        
        updateTable();
    });
    return false;
}

function updateTable() {
    
    fetch('http://localhost:8080/api/foods',{
        mode: 'cors',
        headers: {
            'Access-Control-Allow-Origin':'*'
          }

    })
        .then(function (request) {
            return request.json();
        })
        .then(function(jsonData) {
            fillTable(jsonData);
            console.log(jsonData);
        });
}

function fillTable(menuoptions) {
    let tbody = document.querySelector('#food-tbody');
    tbody.innerHTML = '';
    for(let i = 0; i < menuoptions.length; i++) {
        let menu = menuoptions[i];
        let tr = document.createElement('tr');
        tr['raw-data'] = menu;

        let menuType = document.createElement('td');
        menuType.innerHTML = menu.type.type;
        tr.appendChild(menuType);

        let menuTitle = document.createElement('td');
        menuTitle.innerHTML = menu.title;
        tr.appendChild(menuTitle);

        let menuDesc = document.createElement('td');
        menuDesc.innerHTML = menu.description;
        tr.appendChild(menuDesc);

        tbody.appendChild(tr);
    }
}
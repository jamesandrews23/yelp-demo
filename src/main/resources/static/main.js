function executeSearch(){
    let search = document.getElementById('search').value;
    fetch("/restaurant/phone/" + search).then(response => response.text()
        .then(data => document.getElementById('display').innerHTML = data));
}

document.getElementById('runSearch').addEventListener('click', e => executeSearch());
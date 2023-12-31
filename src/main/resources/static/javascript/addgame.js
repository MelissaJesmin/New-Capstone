//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const headers = {
    'Content-Type': 'application/json',
}

const baseUrl = "http://localhost:8080/api/v1";


const form = document.querySelector('form');
const gameThumbnail = document.getElementById('gameThumbnail');
const gameName = document.getElementById('gameName');
const gameGenre = document.getElementById('gameGenre');
const gamePlatform = document.getElementById('gamePlatform');
const gameCost = document.getElementById('gameCost');


async function addGame(obj) {
    const response = await fetch(`${baseUrl}/addgame/${userId}`, {
        method: 'POST',
        headers,
        body: JSON.stringify(obj)
    }).catch(err => console.error(err.message))
    if(response.status === 200) {
          window.location.replace('dashboard.html');
       }
}


const handleSubmit = async (e) => {
    e.preventDefault();

     if (typeof userId === 'undefined') {
             Swal.fire({
                 title: 'Log in first',
                 icon: 'warning',
                 showCancelButton: true,
                 confirmButtonText: 'Sign In',
                 cancelButtonText: 'Cancel'
             }).then((result) => {
                 if (result.isConfirmed) {
                     window.location.href = 'login.html';
                 }
             });
             return;
         }

    let bodyObj = {
         thumbnail: gameThumbnail.value,
         name: gameName.value,
         genre: gameGenre.value,
         platform: gamePlatform.value,
         cost: gameCost.value
    }
    await addGame(bodyObj);

    gameThumbnail.value = ''
    gameName.value = ''
    gameGenre.value = ''
    gamePlatform.value = ''
    gameCost.value = ''
}
form.addEventListener("submit", handleSubmit);
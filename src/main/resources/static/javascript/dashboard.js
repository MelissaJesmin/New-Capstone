//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const dashboardContainer = document.getElementById("displayDashboard");
const headers = {
    'Content-Type': 'application/json',
}

const baseUrl = "http://localhost:8080/api/v1";

async function getGamesByUser(userId) {
    await fetch(`${baseUrl}/dashboard/${userId}`, {
        method: 'GET',
        headers
    }).then(res => res.json()).then(data => createDashboardCards(data)).catch(err => console.error(err))
}

const createDashboardCards = (array) => {
    dashboardContainer.innerHTML = "";

    array.forEach(game => {
        let gameCard = document.createElement("div");
        gameCard.classList.add("dashboard-card");
        gameCard.innerHTML = `
       <div class="center">
      <div class="article-card">
      <div class="content">
       <p class="game-name">${game.name}</p>
       <p class="game-genre">Genre: ${game.genre}</p>
     <p class="game-platform">Platform: ${game.platform}</p>
      <p class="game-cost">Cost: ${game.cost}</p>
    </div>

   <img src= ${game.thumbnail} class = "game-thumbnail">
 <button class="link" id="delete" onclick="handleDelete(${game.id})"> &#128465;</button>
   </div>

  </div>

     `
        dashboardContainer.append(gameCard);
    });
}

window.addEventListener('load', () => {
    getGamesByUser(userId);
});

function handleLogout(){
    let c = document.cookie.split(";");
    for (let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

async function handleDelete(userId){
    await fetch(`${baseUrl}/${userId}`, {
        method: 'DELETE',
        headers
    }).catch(err => console.error(err))
    return getGamesByUser(userId);
}
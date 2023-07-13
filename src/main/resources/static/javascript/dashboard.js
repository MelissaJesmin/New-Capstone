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
                <div>
                <img src= ${game.thumbnail} class = "game-thumbnail">
                </div>
                <div>
                <h3  class="game-name"> ${game.name}</h3>
                </div>
                <p  class="game-genre"> Genre: ${game.genre}</p>
                <p  class="game-platform"> Platform: ${game.platform}</p>
                <p  class="game-cost"> Cost: ${game.cost}</p>
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
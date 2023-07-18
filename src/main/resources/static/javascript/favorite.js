const cookieArr = document.cookie.split('=');
const userId = cookieArr[1];

const gameContainer = document.getElementById("displayFavorite");

const headers = {
    'Content-Type': 'application/json',
}

const baseUrl = "http://localhost:8080/api/v1";

async function getFavoriteGames(userId) {
    await fetch(`${baseUrl}/favorites/${userId}`, {
        method: 'GET',
        headers
    }).then(res => res.json()).then(data => createGameCards(data)).catch(err => console.error(err))
}


const createGameCards = (array) => {
    gameContainer.innerHTML = "";

    array.forEach(game => {
        let gameCard = document.createElement("div");
        gameCard.classList.add("game-card");
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
        gameContainer.append(gameCard);
    });
}


window.addEventListener('load', () => {
    getFavoriteGames(userId);
});

async function handleDelete(userId){
    await fetch(`${baseUrl}/deleteFavorites/${userId}`, {
        method: 'DELETE',
        headers
    }).catch(err => console.error(err))
    return getFavoriteGames(userId);
}



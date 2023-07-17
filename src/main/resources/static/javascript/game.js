const cookieArr = document.cookie.split('=');
const userId = cookieArr[1];

const gameContainer = document.getElementById("displayGames");

const headers = {
    'Content-Type': 'application/json',
}

const baseUrl = "http://localhost:8080/api/v1";

async function getAllGames(userId) {
    await fetch(`${baseUrl}/game`, {
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
                <div>
                <img src= ${game.thumbnail} class = "game-thumbnail">
                </div>
                <div>
                <h3  class="game-name"> ${game.name}</h3>
                </div>
                <p  class="game-genre"> Genre: ${game.genre}</p>
                <p  class="game-platform"> Platform: ${game.platform}</p>
                <p  class="game-cost"> Cost: ${game.cost}</p>
                <button class="btn fill" id="add-favorite" onclick = "addFavoriteGame(${game.id})">+</button>

        `
        gameContainer.append(gameCard);
    });
}


window.addEventListener('load', () => {
    getAllGames();
});



async function addFavoriteGame(gameId) {
    console.log(gameId)
    const obj = {
        "gameId": gameId
    };
    console.log(obj)
    const response = await fetch(`${baseUrl}/addFavoriteGame/${userId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // Specify the content type as JSON
            // Add other headers if needed
        },
        body: JSON.stringify(obj), // Convert the JavaScript object to JSON
    }).catch(err => console.error(err.message));

    if (response.status === 200) {
        window.location.replace('favorite.html');
    }
}


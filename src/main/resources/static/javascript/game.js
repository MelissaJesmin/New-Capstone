

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


const createGameCards = (game) => {
    gameContainer.innerHTML = "";

    game.forEach(obj => {
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

               <button class="btn fill" id="delete"> &#128465;</button>
        `
        gameContainer.append(gameCard);
    });
}



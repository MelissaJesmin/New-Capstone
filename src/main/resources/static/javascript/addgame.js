const form = document.querySelector('form');
const gameThumbnail = document.getElementById('gameThumbnail');
const gameName = document.getElementById('gameName');
const gameGenre = document.getElementById('gameGenre');
const gamePlatform = document.getElementById('gamePlatform');
const gameCost = document.getElementById('#gameCost');

async function addGame(obj) {
    const response = await fetch(`${baseUrl}/addGame`, {
        method: 'POST',
        headers,
        body: JSON.stringify(obj)
    }).catch(err => console.error(err.message))
    if(response.status === 200) {
        return getAllGames(userId);
    }
}

const handleSubmit = async (e) => {
    e.preventDefault();
    let bodyObj = {
         thumbnail: gameThumbnail.value,
         title: gameName.value,
         genre: gameGenre.value,
         platform: gamePlatform.value,
         cost: gameCost.value,
    }
    await addGame(bodyObj);

    gameThumbnail.value = ''
    gameName.value = ''
    gameGenre.value = ''
    gamePlatform.value = ''
    gameCost.value = ''
}


form.addEventListener("submit", handleSubmit);
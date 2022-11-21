let artists = document.getElementsByClassName("entity")

const MAX_ARTISTS = 10;
let currentSelectedArtists = 0;
updateSelectedArtistsCounter();

for (let artist of artists) {
    artist.addEventListener("click", function() {
        console.log("Event: click on artist " +
            "{artistName = "+artist.getElementsByTagName( "span")[0].innerText+"}");

        if (artist.classList.contains("entity-selected")) {
            artist.classList.remove("entity-selected");
            currentSelectedArtists -= 1;
            updateSelectedArtistsCounter();
            updateGetPlaylistButton();
        } else if (artistNotSelected()) {
            artist.classList.add("entity-selected");
            currentSelectedArtists += 1;
            updateSelectedArtistsCounter();
            updateGetPlaylistButton();
        } else {
            scrollToTop();
        }
    });
}

function artistNotSelected() {
    return currentSelectedArtists < MAX_ARTISTS;
}

function updateGetPlaylistButton() {
    const getPlaylistButton = document.getElementById("get-playlist-button");
    if (artistNotSelected()) {
        disableButton(getPlaylistButton);
    } else {
        enableButton(getPlaylistButton);
    }
}

function disableButton(button) {
    if (button.classList.contains("disabled")) {
        return;
    }
    button.classList.add("disabled");
}

function enableButton(button) {
    if (!button.classList.contains("disabled")) {
        return;
    }
    button.classList.remove("disabled");
}

function scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
}

function updateSelectedArtistsCounter() {
    const currentSelectedSpan = document.getElementById("current-selected");
    const maxArtistsSpan = document.getElementById("max-artists");

    currentSelectedSpan.innerText = currentSelectedArtists;
    maxArtistsSpan.innerText = MAX_ARTISTS;
}

function getPlaylist(updateArtistsUrl, playlistPageUrl) {
    updateSelectedArtists(updateArtistsUrl);
    forwardToPlaylistPage(playlistPageUrl);
}

function forwardToPlaylistPage(url) {
    window.location.href = url;
}

function updateSelectedArtists(url) {
    let artistsJson = getSelectedArtistsJson();
    let data = {"selected-artists":artistsJson};

    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(response) {
            console.log(response);
        },
        error: function (response) {
            console.log(response);
        }
    });
}

function getSelectedArtistsJson() {
    const selectedArtists = document.getElementsByClassName("entity-selected");
    let selectedArtistsNamesArray = [];

    for (let artist of selectedArtists) {
        selectedArtistsNamesArray.push(artist.getElementsByTagName( "span")[0].innerText);
    }

    return JSON.stringify(selectedArtistsNamesArray);
}

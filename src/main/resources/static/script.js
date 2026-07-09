const button = document.getElementById("choose-btn");

const message = document.getElementById("message");

button.addEventListener("click", () => {

    document.getElementById("start-screen").style.display = "none";

    document.getElementById("food-screen").style.display = "block";

    fetch("/current")
        .then(response => response.json())
        .then(data => {

            const container = document.getElementById("food-container");

            container.innerHTML = "";

            data.forEach((food, index) => { //lägger maträtten i listan från array i endpointen, samt indexet

                const div = document.createElement("div");

                div.classList.add("food-card");

                div.innerHTML = `
                    <h2>${food.foodName}</h2>

                    <div class="food-image">
                    </div>

                    <button>Byt maträtt</button>
                `;

                container.appendChild(div);

                const replaceButton = div.querySelector("button"); //Tar knappen från div, letar inte igenom hela docuemnt

                replaceButton.addEventListener("click", () => {
                    fetch(`/replace?index=${index}`,
                        {   
                            method: "POST",

                        })

                    .then(response => { //kollar response i foodcontroller för att visa 200 eller felmeddelande
                        if(response.ok) {
                            return response.json()
                        } else {
                           return response.text()
                        }

                    })
                    .then(data => {

                        if(Array.isArray(data)) {
                            div.querySelector("h2").innerHTML = data[index].foodName
                        } else {
                            message.innerHTML = data
                        }

                        
                    });
                });

                
            });

        });

});

fetch("/echo/json/",
{
    method: "POST",
    body: data
})
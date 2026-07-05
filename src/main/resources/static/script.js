const button = document.getElementById("choose-btn");

button.addEventListener("click", () => {

    // Göm startsidan
    document.getElementById("start-screen").style.display = "none";

    // Visa matsidan
    document.getElementById("food-screen").style.display = "block";

    fetch("/current")
        .then(response => response.json())
        .then(data => {

            const container = document.getElementById("food-container");

            container.innerHTML = "";

            data.forEach(food => {

                const div = document.createElement("div");

                div.innerHTML = `
                    <h2>${food.foodName}</h2>
                    <p>${food.foodType}</p>
                    <p>${food.foodPrice} SEK</p>
                `;

                container.appendChild(div);
            });

        });

});
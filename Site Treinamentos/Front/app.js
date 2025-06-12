document.getElementById("formCadastro").addEventListener("submit", function (e) {
  e.preventDefault();

  const nome = document.getElementById("nome").value;
  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;
  const confirmar = document.getElementById("confirmar").value;

  if (senha !== confirmar) {
    alert("As senhas não coincidem.");
    return;
  }

  const dados = { nome, email, senha };

  fetch("http://localhost:8080/api/usuarios", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(dados)
  })
    .then(res => {
      if (res.ok) {
        alert("Cadastro realizado com sucesso!");
        window.location.href = "login.html";
      } else {
        return res.json().then(err => { throw new Error(err.message || "Erro ao cadastrar."); });
      }
    })
    .catch(err => alert("Erro: " + err.message));
});
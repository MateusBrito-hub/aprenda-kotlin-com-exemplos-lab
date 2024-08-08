enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado com sucesso na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Kotlin para Iniciantes", 120, Nivel.BASICO)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 180, Nivel.INTERMEDIARIO)
    val kotlinAvancado = ConteudoEducacional("Kotlin Avançado", 240, Nivel.DIFICIL)
    
    // Criando uma formação
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado))
    
    // Criando usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    // Tentando matricular o mesmo usuário novamente
    formacaoKotlin.matricular(usuario1)
    
    // Exibindo a lista de inscritos
    println("Inscritos na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nome }}")
}


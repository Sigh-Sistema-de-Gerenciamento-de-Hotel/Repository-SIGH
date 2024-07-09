package visao.padrao;

import visao.TelaErro;

public class CPF {

    // Método estático para validar o CPF
    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");
        
        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador > 9) {
            primeiroDigitoVerificador = 0;
        }

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador > 9) {
            segundoDigitoVerificador = 0;
        }

        // Verificar os dígitos calculados com os dígitos informados
        return cpf.charAt(9) == Character.forDigit(primeiroDigitoVerificador, 10)
            && cpf.charAt(10) == Character.forDigit(segundoDigitoVerificador, 10);
    }

    // Exibir mensagem de erro
    public static void exibirMensagemErro(String mensagem) {
        TelaErro dadosIncorretos = new TelaErro(mensagem);
        dadosIncorretos.setLocationRelativeTo(null);
        dadosIncorretos.setVisible(true);
    }

    // Classe principal para testes
    public static void main(String[] args) {
        String cpf = "123.456.789-09"; // Exemplo de CPF inválido
        
        if (!cpf.isEmpty() && !cpf.trim().isEmpty()) {
            if (!validarCPF(cpf)) {
                exibirMensagemErro("CPF inválido. Por favor, insira um CPF válido.");
            } else {
                // Setar CPF na classe de hospedagem
                // hos.setCpf(Integer.valueOf(cpf)); 
            }
        }
    }
}


/*import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CPF {
    private String cpf;
    private static final String Formato = "###.###.###-##";
    
    public CPF(String C) {
        this.cpf = this.Format(C,false);
    }
    
    
    public boolean isCPF(){
        
        if (this.cpf.equals("00000000000") || 
            this.cpf.equals("11111111111") || 
            this.cpf.equals("22222222222") || 
            this.cpf.equals("33333333333") ||
            this.cpf.equals("44444444444") ||
            this.cpf.equals("55555555555") ||
            this.cpf.equals("66666666666") ||
            this.cpf.equals("77777777777") ||
            this.cpf.equals("88888888888") ||
            this.cpf.equals("99999999999") ||
            this.cpf.length() != 11)
            return(false);
        
        char dig10, dig11; 
        int sm, i, r, num, peso; 

        try { 
            // Calculo do primeiro Digito Verificador 
            sm = 0; 
            peso = 10; 
            for (i=0; i<9; i++) { 
                num = (int)(this.cpf.charAt(i) - 48); 
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig10 = '0'; 
            else 
                dig10 = (char)(r + 48); 

            // Calculo do segundo Digito Verificador 
            sm = 0; 
            peso = 11; 
            for(i=0; i<10; i++) { 
                num = (int)(this.cpf.charAt(i) - 48);
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig11 = '0'; 
            else 
                dig11 = (char)(r + 48); 

            if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10))) 
                return(true); 
            else return(false);
        } catch(Exception e) { 
            return(false); 
        } 
    }

    public String getCPF(boolean Mascara) {
        return Format(this.cpf,Mascara);
    }

    private String Format(String C, boolean Mascara){
        if(Mascara){
            return(C.substring(0, 3) + "." + C.substring(3, 6) + "." +
            C.substring(6, 9) + "-" + C.substring(9, 11));
        }else{
            C = C.replace(".","");
            C = C.replace("-","");
            return C;
        }
    }
    
    
    public static DefaultFormatterFactory getFormat(){
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }
}*/
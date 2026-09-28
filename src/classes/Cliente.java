package classes;

public record Cliente(
        String nome,
        int cpf,
        int whatsapp,
        double totalCompras,
        boolean oferta){}

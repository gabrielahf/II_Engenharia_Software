package genericos.Exercicio;

import java.util.Comparator;


    public class ColetaComparaCodLogradouro implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Coleta c1, c2;
            c1 = (Coleta) o1;
            c2 = (Coleta) o2;
            if (c1.getCodLogradouro() < c2.getCodLogradouro())
                return -1;
            else if (c1.getCodLogradouro() > c2.getCodLogradouro())
                return +1;
            return 0;
        }
    }

}

package Controlador;

import Modelo.Jugador;
import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import util.JPAUtils;

public class Controlador {
    private Jugador jugador;
    
    public void crear(long id, String cedula,String nombre,String apellido){
        EntityManager em = JPAUtils.getEntityManager();
        jugador = new Jugador(id, cedula, nombre, apellido);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(jugador);
        tr.commit();
        em.close();
    }
    public Jugador buscar(long id) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    int cuentaB = 50000;
    int cuenta1 = 1000;
    int cuenta2 = 1000;
    int cuenta3 = 1000;
    int cuenta4 = 1000;
    int val1 = 5;
    int val2 = 5;
    int val3 = 5;
    int val4 = 5;

    public void apostar() {
        cuenta1 -= 10;
        cuenta2 -= 10;
        cuenta3 -= 10;
        cuenta4 -= 10;
        cuentaB += 40;
    }
    
    public void apostarMartingala(boolean g1, boolean g2, boolean g3, boolean g4){
        if(!g1){
            val1 *=2;
        }
        cuenta1 -=val1;
        if(!g2){
            val2 *=2;
        }
        cuenta2 -=val1;
        if(!g3){
            val3 *=2;
        }
        if(!g4){
            val4 *=2;
        }
        cuenta1 -=val1;
        cuenta1 -=val1;
        cuentaB += val1;
        cuentaB += val2;
        cuentaB += val3;
        cuentaB += val4;
    }

    public void ganador1(int val) {
        cuentaB -= val;
        cuenta1 += val;
    }

    public void ganador2(int val) {
        cuentaB -= val;
        cuenta2 += val;
    }

    public void ganador3(int val) {
        cuentaB -= val;
        cuenta3 += val;
    }

    public void ganador4(int val) {
        cuentaB -= val;
        cuenta4 += val;
    }

    public int getCuentaB() {
        return cuentaB;
    }

    public int getCuenta1() {
        return cuenta1;
    }

    public int getCuenta2() {
        return cuenta2;
    }

    public int getCuenta3() {
        return cuenta3;
    }

    public int getCuenta4() {
        return cuenta4;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public int getVal3() {
        return val3;
    }

    public int getVal4() {
        return val4;
    }
    

}

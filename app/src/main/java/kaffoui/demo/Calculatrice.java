package kaffoui.demo;
import android.view.View;
public class Calculatrice {


        private double result = 0;
        public Calculatrice effacer(){
            this.result = 0;
            return this;
        }
        public Calculatrice addition(double a, double b){
            this.result = this.result + a + b;
            return this;
        }
        public Calculatrice multiplication(double a, double b){
            if(this.result == 0){
                this.result = a * b;
                return this;
            }
            this.result = this.result * a * b;
            return this;
        }
        public Calculatrice division(double a, double b){
            if(this.result == 0 && b != 0){
                this.result = a / b;
                return this;
            }
            if(a != 0 && b != 0){
                this.result = this.result / a / b;
                return this;
            }
            return this;
        }
        public Calculatrice soustration(double a, double b){
            this.result = this.result - a - b;
            return this;
        }
        public Calculatrice reste(double a, double b){
            if(this.result == 0 && b != 0){
                this.result = a % b;
                return this;
            }
            if(a != 0 && b != 0){
                this.result = this.result % a % b;
                return this;
            }
            return this;
        }
        public int toInt(){
            //Premiere methode
            int result = (int) this.result;
            return result;
        }
        public double toDouble(){
            //Premiere methode
            return this.result;

    }
}

import { instrument } from "./instrument"
export class Company {
    constructor(
        public askPrice: number,
        public bidPrice: number,
        public priceTimeStamp: string,
       
        
    ){}

     public instrument= new instrument('','','','','',-1,-1);
  }



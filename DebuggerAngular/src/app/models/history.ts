import { Time } from "@angular/common";

export class history {
    constructor(
        
            public company: string,
            public action: string,
            public date: string,
            public time: string,
            public shares: number,
            public price: number,
            public balance: number
        
    ){}
  }
import { AbstractControl, FormControl, FormGroup } from '@angular/forms';

export function ValidateDateRange(group: FormGroup) {
    if (group.controls.endDate.value) {
        console.log(group.controls.startDate.value);
        console.log(group.controls.endDate.value);
        console.log(group.controls.startTime.value);
        console.log(group.controls.endTime.value);
        return true;
    }
    return null;
}

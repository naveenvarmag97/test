﻿using Data.Enum;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.ViewModel
{
    public class RegisterViewModel
    {
        [Display(Name = "User name")]
        public string UserName { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "The {0} must be at least {2} characters long.", MinimumLength = 6)]
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "Confirm password")]
        [Compare("Password", ErrorMessage = "The password and confirmation password do not match.")]
        public string ConfirmPassword { get; set; }

        [Required]
        public UserType UserType { get; set; }

        public long EmpID { get; set; }

        public string EmpAddress { get; set; }

        [DataType(DataType.EmailAddress)]
        public string Email { get; set; }
        [Required]
        public string Firstname { get; set; }

        [Required]
        public string Lastname { get; set; }

    }
}

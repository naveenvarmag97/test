using Data.Enum;
using Microsoft.AspNet.Identity.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Entity
{
    public class User : IdentityUser
    {
        public long EmpID { get; set; }

        public string EmpAddress { get; set; }

        public UserType UserType { get; set; }

        public string Firstname { get; set; }

        public string Lastname { get; set; }

    }
}

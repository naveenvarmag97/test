﻿using Data.Entity;
using Microsoft.AspNet.Identity.EntityFramework;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data
{
    public class CRMSDbContext : IdentityDbContext<IdentityUser>
    {
        //cls
        public CRMSDbContext():base("CRMSConnection")
        {
           
        }

        public DbSet<ConfreneceRoom> ConfreneceRoom { get; set; }

        public DbSet<Booking> Bookings { get; set; }

        public DbSet<RoomType> RoomType { get; set; }
    }
}

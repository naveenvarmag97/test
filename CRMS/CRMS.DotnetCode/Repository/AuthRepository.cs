using Data;
using Data.Entity;
using Data.ViewModel;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using Repository.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
   public class AuthRepository: IAuthRepository
    {
        private CRMSDbContext dbContext;
        private UserManager<User> _userManager;
        public AuthRepository(CRMSDbContext context, UserManager<User> userManager)
        {
            dbContext = context;
            _userManager = userManager; // new UserManager<User>(new UserStore<User>(dbContext));
        }

        public async Task<User> FindUser(string userName, string password)
        {
            User user = await _userManager.FindAsync(userName, password);

            return user;
        }

        public async Task<IdentityResult> Register(RegisterViewModel model)
        {
            User user = new User
            {
                UserName = model.UserName ?? model.Email,
                UserType= model.UserType,
                EmpID= model.EmpID,
                Email=model.Email,
                EmpAddress=model.EmpAddress,
                Firstname=model.Firstname,
                Lastname=model.Lastname
            };

            var result = await _userManager.CreateAsync(user, model.Password);

            return result;
        }
    }
}

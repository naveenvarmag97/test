using Data.ViewModel;
using log4net;
using Microsoft.AspNet.Identity;
using Repository;
using Repository.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;

namespace CRMS.Controllers
{
    public class AccountController : BaseApiController
    {
        private IUow _uow;
        private ILog _log;

        public AccountController(IUow uow, ILog log)
        {
            _uow = uow;
            _log = log;
        }

        [Authorize]
        public IHttpActionResult GetTest()
        {
            _log.Info("Test Info Message");

            return Ok(new string[] { "Test", "Test2" });
        }

        [AllowAnonymous]
        public async Task<IHttpActionResult> RegisterUser(RegisterViewModel model)
        {
           var result = await _uow.AuthRepository.Register(model);

            if(result.Succeeded)
                return Ok();
            else
                return GetErrorResult(result);
        }

        private IHttpActionResult GetErrorResult(IdentityResult result)
        {
            if (result == null)
            {
                return InternalServerError();
            }

            if (!result.Succeeded)
            {
                if (result.Errors != null)
                {
                    foreach (string error in result.Errors)
                    {
                        ModelState.AddModelError("", error);
                    }
                }

                if (ModelState.IsValid)
                {
                    // No ModelState errors are available to send, so just return an empty BadRequest.
                    return BadRequest();
                }

                return BadRequest(ModelState);
            }

            return null;
        }
    }
}

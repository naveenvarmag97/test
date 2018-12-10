using log4net;
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
    public class RoomTypeController : BaseApiController
    {
        public RoomTypeController(IUow uow, ILog log)
        {
            _uow = uow;
            _log = log;
        }

        public IUow _uow { get; }
        public ILog _log { get; }

        public async Task<IHttpActionResult> GetRoomTypes()
        {
            return Ok(await _uow.RoomTypeRepository.Get());
        }
    }
}

using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPhones.Pages.phones;
using RazorPhones.Data;
namespace RazorPhones.Pages;

public class IndexModel : PageModel
{
    public IList<Phone> Phone { get; set; } = default!;
    private readonly RazorPhones.Data.PhonesContext _context;

    public IndexModel(RazorPhones.Data.PhonesContext context)
    {
        _context = context;
    }

    public async Task OnGetAsync()
    {
        if (_context.Phones != null)
        {
            Phone = await _context.Phones.OrderByDescending(p => p.Modified).Take(3).ToListAsync();
        }
    }
}
